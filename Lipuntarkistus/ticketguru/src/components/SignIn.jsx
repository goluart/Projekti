import { Button, Stack, Paper, Typography } from "@mui/material";

const SignIn = () => {

    return (
        <Paper elevation={24} style={{ padding: '20px', maxWidth: '500px' }}>
            <Stack container spacing={2}>
                <Typography variant='h4' >Welcone to Ticketguru ticket app</Typography>
            <Button href="/get" variant="text">
                    Fetch ticket
                </Button>
                <Button href="/check" variant="text">
                    Check ticket
                </Button>
            </Stack>
        </Paper>
    )
}

export default SignIn