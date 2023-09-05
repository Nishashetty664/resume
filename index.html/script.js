document.getElementById("loginForm").addEventListener("submit", function(event) {
  event.preventDefault();
  
  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  
  // Perform authentication logic here (e.g., check credentials)
  if (username === "user" && password === "pass") {
    alert("Login successful!");
  } else {
    alert("Invalid credentials. Please try again.");
  }
});