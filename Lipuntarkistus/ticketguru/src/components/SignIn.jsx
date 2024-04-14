import { useEffect, useState } from 'react';
import { Form } from 'react-router-dom';

const SignIn = () => {

    const [token, setToken] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');

    const requestOptions = {
        method: 'POST',
        redirect: 'follow',
        body: JSON.stringify({
            username: username,
            password: password
        }),
        headers: {
            'Content-Type': 'application-json'
        }
    }

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    }

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    }

    const getToken = async () => {
        fetch('https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/login', requestOptions)
            .then(response => response.json())
            .then(data => setToken(data.accessToken))
            .catch(error => {
                alert(error, 'Error')
            })
        console.log(token)
    }

    return (
        <div>
            <form>
                <label>User
                    <input type='text' onChange={handleChangeUsername} name='username' /><br />
                </label>
                <label>Password
                    <input type='text' onChange={handleChangePassword} name='password' /><br />
                </label>
                <input type='button' onClick={getToken} value='Sign in' />
                <input type='hidden' value={token} />
            </form>
        </div>)
}

export default SignIn