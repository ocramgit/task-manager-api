function createTask(task, task_category) {

    fetch('http://localhost:8080/task', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify({
            task: task,
            description: {
                task_category: task_category
            }
    })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error creating task');
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error('Error creating task:', error);
    });
}

document.getElementById('taskForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const taskValue = document.getElementById('task').value;
    const descValue = document.getElementById('desc').value;

    createTask(taskValue, descValue);
});

function getAllTasks() {
    fetch('http://localhost:8080/task', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error fetching tasks');
        }
        return response.json();
    })
    .then(data => {
        const dataField = document.getElementById("dataP");
        console.log('Data field:', dataField);

        dataField.value = JSON.stringify(data);
    })
    .catch(error => {
        console.error('Error fetching tasks:', error);
    });
}

document.getElementById('taskGet').addEventListener('submit', function(event) {
    event.preventDefault();
    getAllTasks();
});

document.getElementById('taskGet').addEventListener('submit', function() {
    getAllTasks();
});