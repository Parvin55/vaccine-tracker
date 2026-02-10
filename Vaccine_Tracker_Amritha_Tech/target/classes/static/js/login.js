const { createApp } = Vue;

createApp({
    data() {
        return {
            email: "",
            password: "",
            error: ""
        };
    },
    methods: {
        login() {
            if (!this.email || !this.password) {
                this.error = "Please enter email and password";
                return;
            }

            axios.post("http://localhost:8080/api/auth/login", {
                email: this.email,
                password: this.password
            })
            .then(response => {
                localStorage.setItem("userId", response.data.userId);
                alert("Login successful");
                window.location.href = "index.html"; //redirecting ti index page 
            })
            .catch(() => {
                this.error = "Invalid email or password";
            });
        }
    }
}).mount("#app");