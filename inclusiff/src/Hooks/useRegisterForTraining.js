import axios from 'axios'

function useRegisterForTraining() {
    const register = async (userId, trainingId) => {
        const response = await axios.post('http://localhost:10004/trainings/register', {
            userExternalId: userId, trainingExternalId: trainingId
        });

        if (response.status === 200) {
            return response.data;
        } else {
            console.error("Something went wrong!");
        }
    }

    return { register };
}

export default useRegisterForTraining;