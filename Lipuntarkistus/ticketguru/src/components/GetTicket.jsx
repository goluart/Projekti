import { Button, TextField, Alert, Grid, Stack, Paper, List, ListItem, ListItemText, Typography } from "@mui/material";
import { useState } from "react";
import { Link } from "react-router-dom";

const GetTicket = () => {

    const username = 'hallinto';
    const password = 'hallinto';
    const [ticket, setTicket] = useState({});
    const [ticketUUID, setTicketUUID] = useState("");
    const [err, setErr] = useState('');
    const [data, setData] = useState('');
    const [used, setUsed] = useState('');

    const requestOptions = {
        method: 'GET',
        cache: 'no-cache',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${btoa(username + ':' + password)}`
        }
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const fetchTicket = async () => {
        try {
            const response = await fetch(`http://localhost:8080/tarkastukset/${ticketUUID}`, requestOptions)
            const json = await response.json();
            setTicket(json)
        } catch (error) {
            setErr('Error fetching ticket: ', error.message)
        }
        showTicket();
    };

    console.log(ticket)

    const showTicket = () => {
        if (ticket.kayttoPvm > 0) {
            setUsed(ticket.kayttoPvm.getDate() + "." + ticket.kayttoPvm.getMonth() + "." + ticket.kayttoPvm.getYear());
        } if (ticket.kayttoPvm == null) {
            setUsed('Not used')
        } if (ticket == null) {
            setData(<p>Fetch failed: {err}</p>)
        } else {
            setData( // tieto tulee json muodossa, mutta lipputyypin nimeä ei pysty lukemaan
                <List>
                    <ListItem>
                        <Typography variant="body1">Event: {ticket.tapahtumaNimi}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Place: {ticket.paikkaNimi}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Ticket type: {ticket.lipputyyppi}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Ticket used: {used}</Typography>
                    </ListItem>
                </List>
            )
        }
    };

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
                <TextField id="standard-basic" label="Write ticket code" variant="standard" onChange={handleChangeTicketUUID} name="ticketUUID" />
                <Button variant="contained" onClick={fetchTicket}>Fetch ticket</Button>
                {data}
                <Button href="/check" variant="text">
                    Back to checks ticket
                </Button>
            </Stack>
        </Paper>
    )
};

export default GetTicket