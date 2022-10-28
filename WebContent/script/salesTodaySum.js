function calcSum() {

  const table = document.getElementById('salesToday');
 

  let sum = 0;
  for(let i = 1; i < table.rows.length; i++)  {
    sum += parseInt(table.rows[i].cells[2].innerHTML);
  }
  

  document.getElementById('sum').innerText = sum.toLocaleString();
  
  

}