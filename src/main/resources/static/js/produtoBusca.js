
  document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('searchForm');

    form.addEventListener('submit', function(event) {
      event.preventDefault();
      const selected = document.querySelector('input[name="search"]:checked').value.toLowerCase();

      const rows = document.querySelectorAll('tbody tr');

      rows.forEach(row => {
        const nomeProduto = row.querySelector('td:nth-child(2)').textContent.toLowerCase();
        if (selected === 'todos' || nomeProduto.includes(selected)) {
          row.style.display = '';
        } else {
          row.style.display = 'none';
        }
      });
    });
  });