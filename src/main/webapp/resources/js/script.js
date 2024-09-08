document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('loginForm:username').value;
    const password = document.getElementById('loginForm:password').value;
    
    // Simple client-side validation
    if(username === '' || password === '') {
        alert('Please fill in both fields.');
    } else {
        
    }
});
