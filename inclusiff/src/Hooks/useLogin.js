import axios from 'axios'

function useLogin() {
    const login = async (email, password) => {
        const response = await axios.post('http://localhost:10001/user/login', {
            email: email, password: password
        });

        if (response.status === 200) {
            return response.data;
        } else {
            console.error("Something went wrong!");
        }
    }

    return { login };
}

export default useLogin;