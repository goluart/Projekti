import { Button, TextField, Stack, Paper, List, ListItem, Typography } from "@mui/material";
import { useEffect, useState } from "react";

const GetTicket = () => {

    const [password, setPassword] = useState('');
    const [username, setUsername] = useState('');
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

    const handleChangeUsername = (event) => {
        setUsername(event.target.value);
    };

    const handleChangePassword = (event) => {
        setPassword(event.target.value);
    };

    const handleChangeTicketUUID = (event) => {
        setTicketUUID(event.target.value);
    };

    const fetchTicket = async () => {
        try {
            const response = await fetch(`https://projekti-ticketguru-tiimi4.rahtiapp.fi/liput?tarkistuskoodi=${ticketUUID}`, requestOptions)
            const json = await response.json();
            setTicket(json)
        } catch (error) {
            setErr('Error fetching ticket: ', error.message)
        }
    };

    useEffect(() => {
        showTicket();
    }, [ticket])

    const showTicket = () => {
        if (ticket.kayttoPvm > 0) {
            setUsed(ticket.kayttoPvm.getDate() + "." + ticket.kayttoPvm.getMonth() + "." + ticket.kayttoPvm.getYear());
        } if (ticket.kayttoPvm == null) {
            setUsed('Not used')
        } if (ticket == null) {
            setData(<p>Fetch failed: {err}</p>)
        } else {
            setData(
                <List>
                    <ListItem>
                        <Typography variant="body1">Event: {ticket.tapahtumanNimi}</Typography>
                    </ListItem>
                    <ListItem>
                        <Typography variant="body1">Place: {ticket.tapahtumaPaikka}</Typography>
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
                <TextField label="Username" variant="standard" onChange={handleChangeUsername} name="username" />
                <TextField label="Password" variant="standard" onChange={handleChangePassword} name="password" />
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