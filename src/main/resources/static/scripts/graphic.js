function mostrarHTML(contenedorId) {
    //Ocultar todos los contenedores de contenido
    var contenedores = document.querySelectorAll('.content-container');
    contenedores.forEach(function(contenedor) {
        contenedor.style.display = 'none';
    });

    //Mostrar el contenedor de contenido específico
    var contenedorEspecifico = document.getElementsByName(contenedorId);
    contenedorEspecifico.forEach(function(contenedor) {
        contenedor.style.display = 'block';
    });
}

//Datos del gráfico de barras.
var data = {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo"],
    datasets: [{
        label: 'Consumo Mensual',
        data: [12, 19, 3, 5, 2],
        backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)'
        ],
        borderColor: [
            'rgba(255,99,132,1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)'
        ],
        borderWidth: 1
    }]
};

//Configuración del gráfico.
var options = {
    scales: {
        y: {
            beginAtZero: true
        }
    }
};

//Crear el gráfico de barras.
var ctx = document.getElementById('barChart').getContext('2d');
var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: data,
    options: options
});

//Autocompletado de dirección.
function initAutocomplete() {
  const input = document.getElementById('location-input');
  const autocomplete = new google.maps.places.Autocomplete(input, {
    types: ['geocode']
  });
}