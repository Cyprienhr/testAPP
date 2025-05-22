const form = document.getElementById('studentForm');
const formContainer = document.getElementById('formContainer');
const formTitle = document.getElementById('formTitle');
const tableBody = document.querySelector('#studentTable tbody');
const API_URL = '/api/students';

// Load all students
window.onload = () => fetchStudents();

// Show form to add a new student
function showAddForm() {
    form.reset();
    form.studentId.value = '';
    formTitle.textContent = 'Add New Student';
    formContainer.style.display = 'block';
}

// Cancel editing or adding
function cancelEdit() {
    form.reset();
    formContainer.style.display = 'none';
}

// Submit form (CREATE or UPDATE)
form.addEventListener('submit', async (e) => {
    e.preventDefault();

    const student = {
        name: form.name.value,
        department: form.department.value,
        module: form.module.value,
        marks: form.marks.value,
        lecturer: form.lecturer.value
    };

    const studentId = form.studentId.value;

    if (studentId) {
        // UPDATE
        await fetch(`${API_URL}/${studentId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(student)
        });
    } else {
        // CREATE
        await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(student)
        });
    }

    form.reset();
    formContainer.style.display = 'none';
    fetchStudents();
});

// READ all students
async function fetchStudents() {
    const res = await fetch(API_URL);
    const students = await res.json();
    tableBody.innerHTML = '';

    students.forEach(s => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${s.name}</td>
            <td>${s.department}</td>
            <td>${s.module}</td>
            <td>${s.marks}</td>
            <td>${s.lecturer}</td>
            <td>
                <button onclick="editStudent(${s.id})">Edit</button>
                <button onclick="deleteStudent(${s.id})">Delete</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

// DELETE student
async function deleteStudent(id) {
    if (confirm('Are you sure you want to delete this student?')) {
        await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });
        fetchStudents();
    }
}

// Fill form to UPDATE
async function editStudent(id) {
    const res = await fetch(`${API_URL}/${id}`);
    const s = await res.json();

    form.studentId.value = s.id;
    form.name.value = s.name;
    form.department.value = s.department;
    form.module.value = s.module;
    form.marks.value = s.marks;
    form.lecturer.value = s.lecturer;

    formTitle.textContent = 'Edit Student';
    formContainer.style.display = 'block';
}
