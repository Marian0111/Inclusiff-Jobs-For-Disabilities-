import axios from 'axios'

function useLearners() {
    const getLearners = async () => {
        const response = await axios.get('http://localhost:10001/users')
        if (response.status === 200) {
            return response.data
        } else {
            console.error("Error getting learners")
        }
    }

    return {getLearners}
}

export default useLearners