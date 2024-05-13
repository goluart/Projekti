import { Button, TextField, Alert, Stack, Paper } from "@mui/material";
import { useState } from "react";

const CheckTicket = () => {

    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
    const [ticketUUID, setTicketUUID] = useState('');
    const [eventName, setEventName] = useState('');
    const [err, setErr] = useState('');
    const [message, setMessage] = useState('');
    const [valid, setValid] = useState('')

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    };

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    };

    const handleChangeEventName = (event) => {
        setEventName(event.target.value);
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const requestOptions = {
        method: 'POST',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${btoa(username + ':' + password)}`
        },
        body: JSON.stringify({
            "tarkastuskoodi": `${ticketUUID}`,
            "tapahtumaNimi": `${eventName}`
        })
    };

    const usedTicket = async () => {
        try {
            console.log(requestOptions)
            const response = await fetch(`https://projekti-ticketguru-tiimi4.rahtiapp.fi/tarkastukset`, requestOptions)
            const json = await response.json();
            setValid(json)
        } catch (error) {
            setErr(error.message)
        }
    };

    const doCheck = (event) => {
        event.preventDefault();
        usedTicket();
        console.log(valid.reason)
        if (valid.reason === 'lippua ei löytynyt') {
            setMessage(<Alert severity="error">Ticket not found</Alert>)
        } else {
            if (valid === true) {
                console.log(valid)
                setMessage(<Alert severity="success">Ticket marked as used</Alert>)
            } if (valid === false) {
                console.log(valid)
                setMessage(<Alert severity="warning">Ticket already used</Alert>)
            }
        }
    };

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
                <TextField label="Username" variant="standard" onChange={handleChangeUsername} name="username" />
                <TextField label="Password" variant="standard" onChange={handleChangePassword} name="password" />
                <TextField label="Write event name" variant="standard" onChange={handleChangeEventName} name="eventName" />
                <TextField label="Write ticket code" variant="standard" onChange={handleChangeTicketUUID} name="ticketUUID" />
                <Button variant="contained" onClick={doCheck}>Check ticket</Button>
                {message}
                <Button href="/get" variant="text">
                    Back to fetch ticket
                </Button>
            </Stack>
        </Paper>
    )
};

export default CheckTicket