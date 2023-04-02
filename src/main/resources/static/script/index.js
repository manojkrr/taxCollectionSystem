document.addEventListener('DOMContentLoaded', () => {
    // Calculate cost and distance when button is clicked
    document.querySelector('#calculate-btn').addEventListener('click', () => {
        const entryLocation = document.querySelector('#entry-location').value;
        const exitLocation = document.querySelector('#exit-location').value;

        if (entryLocation && exitLocation) {
            fetch(`/toll/entry/${entryLocation}/exit/${exitLocation}`)
                .then(response => response.json())
                .then(result => {
                    //display the result after receiving the response
                    document.querySelector("#result").style.visibility = "visible";
                    document.querySelector('#distance').textContent = result.totalDistanceInKms + " km";
                    document.querySelector('#cost').textContent = result.amount;
                });
        }
    });
});
