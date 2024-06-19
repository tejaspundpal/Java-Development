document.addEventListener('DOMContentLoaded', function() {
    const btn = document.getElementById('change-color-btn');
    const para = document.getElementById('para');

    btn.addEventListener('click', function() {
        para.classList.toggle('highlight');
    });
});

// Add a class in CSS for highlighting
/*
.highlight {
    background-color: #ffeb3b;
    transition: background-color 0.3s ease;
}
*/
