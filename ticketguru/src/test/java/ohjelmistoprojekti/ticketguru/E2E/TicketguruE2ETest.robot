*** Settings ***
Documentation           Simultaneous users 1
Library         SeleniumLibrary   15.0   5.0
Library         XML
Library         Collections

*** Variables ***
${Chrome1}        Chrome
${Chrome2}        Chrome
${URL}            http://localhost:5173
${Sleep}          2


*** Test Cases ***
Open Two Browsers
        Open Browser        ${URL}        ${Chrome1}
        Sleep               ${Sleep}
        Page Should Contain    Tapahtumat
        Open Browser        ${URL}        ${Chrome2}
        Sleep               ${Sleep}
        Page Should Contain    Tapahtumat

Go To Tapahtumat Page With Chrome1
        Switch Browser        1
        Click Element        //*[@id="root"]/div/nav/div/div/a[1]      
        Input Text           //*[@id="username"]    myyja
        Input Text           //*[@id="password"]    myyja
        Click Button         //*[@id="root"]/div/div/div/div/div/div/form/button
        Click Element        //*[@id="root"]/div/nav/div/div/a[2]
        Page Should Contain    Myy Lippuja

Open Modal For Selling tickets
        Click Button    //*[@id="root"]/div/div/div/div/div/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div[1]/div[8]/button
        

Change Browser
        Switch Browser    2
        Page Should Not Contain    Myy Lippuja
        