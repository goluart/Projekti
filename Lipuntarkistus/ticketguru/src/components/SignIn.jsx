import { useState } from 'react';
import ApiToken from './ApiToken';

const SignIn = () => {

    const [token, setToken] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    }

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    }

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'username': username,
            'password': password
        }),
    }

    const getToken = async () => {
        try {
            const response = await fetch('https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/login', requestOptions);
            const json = await response.json();
            setToken(json.accessToken)
        } catch (error) {
            alert('Error signing in: ', error.message)
        }
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
            </form>
            {token && <ApiToken token={token} />} {/** välitetään token ApiToken.jsx, jotta tieto menee headerissä muihin komponentteihin */}
        </div>)
}

export default SignIn