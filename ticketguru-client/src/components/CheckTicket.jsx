import { Button, TextField, Alert, Stack, Paper } from "@mui/material";
import { useEffect, useState } from "react";
import { SERVER_URL } from '../constants/Constants';
import { useNavigate } from "react-router-dom";

const CheckTicket = () => {

    const [ticketUUID, setTicketUUID] = useState('');
    const [eventName, setEventName] = useState('');
    const [err, setErr] = useState('');
    const [message, setMessage] = useState('');
    const [valid, setValid] = useState('')
    const navigate = useNavigate();

    useEffect(() => {
        const credentials = sessionStorage.getItem('credentials');
        if (credentials === null) {
            navigate("/login", { replace: true });
        }
    }, [navigate]);

    const requestOptions = {
        method: 'POST',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${sessionStorage.getItem('credentials')}`
        },
        body: JSON.stringify({
            "tarkistuskoodi": `${ticketUUID}`,
            "tapahtumaNimi": `${eventName}`
        })
    };

    const handleChangeEventName = (event) => {
        setEventName(event.target.value);
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const checkPressed = () => {
        if (ticketUUID == '' || eventName == '') {
            setMessage(<Alert severity="error">Täytä kaikki kohdat</Alert>)
        } else {
            checkTicket()
        }
    }

    const checkTicket = async () => {
        try {
            const response = await fetch(`${SERVER_URL}/tarkastukset`, requestOptions)
            const json = await response.json();
            setValid(json)
            setErr(response.status)
        } catch (error) {
            setErr(error.message)
        }
    };

    useEffect(() => {
        if (valid.reason === 'lippua ei löytynyt') {
            setMessage(<Alert severity="error">Lippua ei löydy</Alert>)
        } else {
            if (valid.response === true) {
                setMessage(<Alert severity="success">Lippu merkitty käytetyksi</Alert>)
            } if (valid.response === false) {
                setMessage(<Alert severity="warning">Lippu on jo käytetty</Alert>)
            }
        }
    }, [err])

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
                <TextField label="Tapahtuman nimi" variant="standard" onChange={handleChangeEventName} name="eventName" />
                <TextField label="Tarkistuskoodi" variant="standard" onChange={handleChangeTicketUUID} name="ticketUUID" />
                <Button variant="contained" onClick={checkPressed}>Tarkasta</Button>
                {message}
            </Stack>
        </Paper>
    )
};

export default CheckTicket