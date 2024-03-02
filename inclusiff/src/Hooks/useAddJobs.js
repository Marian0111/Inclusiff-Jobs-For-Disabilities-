import axios from 'axios'

function useAddJobs() {
    const addJobs = async (jobDescription, enterpriseId) => {
        const response = await axios.post('http://localhost:10003/enterprise/job-offer', {
            jobDescription: jobDescription, enterpriseId: enterpriseId
        });

        if (response.status === 200) {
            return response.data;
        } else {
            console.error("Something went wrong!");
        }
    }

    return { addJobs };
}

export default useAddJobs;