import { Button, TextField, Alert, Stack, Paper } from "@mui/material";
import { useState } from "react";
import { Link, useParams } from "react-router-dom";

const CheckTicket = () => {

    const username = 'hallinto';
    const password = 'hallinto';
    const [ticketUUID, setTicketUUID] = useState('');
    const [eventName, setEventName] = useState('');
    const [err, setErr] = useState('');
    const [message, setMessage] = useState('');
    const [valid, setValid] = useState('')

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
            "tarkistuskoodi": `${ticketUUID}`,
            "tapahtumaNimi": `${eventName}`
        })
    };

    const usedTicket = async () => {
        try {
            const response = await fetch(`http://localhost:8080/tarkastukset`, requestOptions)
            const json = await response.json();

            console.log(requestOptions)
            setValid(json)
        } catch (error) {
            setErr(error.message) // tulee vastaus not found, pitäisi palauttaa vain http response 204
        }

    };
    // painike käynnistää doCheck tapahtuman
    const doCheck = (event) => {
        event.preventDefault();
        console.log(requestOptions)
        usedTicket(); // käynnistetään patch pyyntö
        if (err.length > 0) {  // jos err muuttujassa on tietoa, välitetään syy patchin epäonnistumisesta
            setMessage(<Alert severity="error">{err}</Alert>)
        } else {
            if (json.response == true) {
                console.log(valid.response)
                setMessage(<Alert severity="success">Ticket marked as used</Alert>) // viesti päivittyy sen mukaan, palautuuko true/false ja arvo välittyy message muuttujalla käyttäjän näkymään
            } if (json.response == false) {
                setMessage(<Alert severity="warning">Ticket already used</Alert>)
            }
        }
    };

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
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