import { Button, TextField, Alert, Stack, Paper } from "@mui/material";
import { useState } from 'react';
import { Link } from 'react-router-dom';

const SignIn = () => {

    const username = 'hallinto';
    const password = 'hallinto';
    const [accessToken, setAccessToken] = useState('');
  //  const [password, setPassword] = useState('');
  //  const [username, setUsername] = useState('');
    const [answer, setAnswer] = useState('');

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    };

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    };

const requestOptions = {
    method: 'GET',
    cache: 'no-cache',
    credentials: 'include',
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Basic ${btoa(username + ':' + password)}`
    }
    };

    const signIn = async () => {
        try {
            const response = await fetch('http://localhost:8080/tapahtumat', requestOptions);
        } catch (error) {
            setAnswer(<Alert severity="error">{error}</Alert>)
        }
        setAnswer(<Alert severity="success">Signed in</Alert>)
    };

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
            <TextField label="Write username" variant="standard" onChange={handleChangeUsername} name="userName" />
                <TextField label="Write password" variant="standard" onChange={handleChangePassword} name="password" />
                <Button variant="contained" onClick={signIn}>Sign in</Button>
            {answer}
            <Button href="/get" variant="text">
                    Fetch ticket
                </Button>
                <Button href="/check" variant="text">
                    Checks ticket
                </Button>
            </Stack>
        </Paper>
    )
}

export default SignIn