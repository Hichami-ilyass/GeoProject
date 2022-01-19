
var position = [];
var params = (new URL(document.location)).searchParams;
var imei = params.get("imei");
var phones = [];


$.ajax({
	url: "PhoneController",
	data: { op:"chart2" },
	method: "POST",
	success: function(data) {
		data.forEach(e => {
			phones.push(e.phone.imei);
		});
		const counts1 = {};
		phones.forEach(function (x) { counts1[x] = (counts1[x] || 0) + 1; });
		var phonsDistinct = phones.filter(function(item, pos, self) {
    		return self.indexOf(item) == pos;
		});
		
		var phoData = []
		phonsDistinct.forEach(function (x) { phoData.push(counts1[x])});
		createchart1(phonsDistinct , phoData);
	}
});





Chart


function createchart1(months , posData){
const ctx = document.getElementById('Chart').getContext('2d');
const Charts = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: months,
        datasets: [{
            label: 'Nombre de postion par Telephone',
            data: posData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

}