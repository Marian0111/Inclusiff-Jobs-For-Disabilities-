import axios from 'axios'

function useGetJobOffers() {
    const getJobOffers = async () => {
        const response = await axios.get('http://localhost:10003/enterprise/job-offer')
        if (response.status === 200) {
            return response.data
        } else {
            console.error('Error getting job offers')
        }
    }

    const getEnterpriseJobOffers = async (enterpriseId) => {
        const response = await axios.get(`http://localhost:10003/enterprise/${enterpriseId}/job-offer`)
        if (response.status === 200) {
            return response.data
        } else {
            console.error('Error getting enterprise job offers')
        }
    }

    return {getJobOffers, getEnterpriseJobOffers}
}

export default useGetJobOffers