import { useState } from 'react';
import { Link } from 'react-router-dom';

const SignIn = () => {

    const [accessToken, setAccessToken] = useState('');
    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
    const [answer, setAnswer] = useState('');

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    };

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    };

    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            'username': username,
            'password': password
        }),
    };

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    }

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    }

    const getToken = async () => {
        try {
            const response = await fetch('https://copypaste-ohjelmistoprojekti-copypaste-ticketguru.rahtiapp.fi/api/login', requestOptions);
            const json = await response.json();
            setAccessToken(json.token)
        } catch (error) {
            alert('Error signing in: ', error.message)
        }
        setAnswer(<p>Token ready</p>)
    };

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
            {answer}
            <Link to={'/get/'+ accessToken}>Get ticket</Link>
            <br/>
            <Link to={'/check/'+ accessToken}>Check ticket</Link>
        
        </div>)
}

export default SignIn