// Select the button using its ID
const saveButton = document.getElementById('btn-save-customer');
const deleteButton = document.getElementById('btn-remove-customer');
const updateButton = document.getElementById('btn-update-customer');

// Add the event listener to the button
saveButton.addEventListener('click', saveCustomer);
deleteButton.addEventListener('click', deleteCustomer);
updateButton.addEventListener('click', updateCustomer);

// Define the function that will be executed when the button is clicked
function saveCustomer() {
    // alert('Button was clicked!');
    let id = document.getElementById('CustomerId').value;
    let name = document.getElementById('CustomerName').value;
    let address = document.getElementById('CustomerAddress').value;
    let salary = document.getElementById('CustomerSalary').value;
    // console.log(id, name, address, salary);

    const customerData = {
        id : id,
        name : name,
        address : address,
        salary : salary
    }
    console.log(customerData);

    const customerJSON = JSON.stringify(customerData);

    //AJAX
    const http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if(http.readyState == 4){
            if(http.status == 201){

            }else{

            }
        }else{

        }
    };

    http.open("POST", "http://localhost:8080/pos/customer", true);
    http.setRequestHeader("Content-type", "application/json");
    http.send(customerJSON);

}

function deleteCustomer(){
    const customerId = document.getElementById("CustomerId").value;
    const http = new XMLHttpRequest();
    http.onreadystatechange = () => {
        if(http.readyState == 4){
            if(http.status == 201){

            }else{

            }
        }else{

        }
    };

    http.open("DELETE", `http://localhost:8080/pos/customer?id=${customerId}`, true);
    http.setRequestHeader("Content-type", "application/json");
    http.send();
}

function updateCustomer(){
    
}


