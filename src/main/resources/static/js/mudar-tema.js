const html = document.documentElement;
const mudarTema = document.getElementById("mudar-tema");

const temaSalvo = localStorage.getItem("tema");
if (temaSalvo) {
    html.setAttribute("data-theme", temaSalvo);
}

mudarTema.addEventListener("click", function() {
    const temaAtual = html.getAttribute("data-theme");
    const novoTema = temaAtual === "dark" ? "light" : "dark"
    html.setAttribute("data-theme", novoTema);
    localStorage.setItem("tema", novoTema);
})