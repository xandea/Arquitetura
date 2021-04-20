# Arquitetura
<p>Desenvolvimento de arquitetura do aplicativo para correção de solos</p>

## Modelos ideais
<p>A modelagem dos valores ideais seguem conforme apresentado na planilha excel de correção de solos.</p>
<p>Como é muito extenso o mapeamento em imagens, foi utilizado o <a href="https://miro.com/app/board/o9J_lRwHN5c=/">Miro</a> 
<p>Um exemplo:</p>
<img src="https://user-images.githubusercontent.com/32207196/110216390-c07f7880-7e8d-11eb-9c51-136dc1d5591c.jpg"/>

<h1 align="center">Melhorias no Código</h1>

<p>Nessa fase do projeto iremos analisar o código desenvolvido até o momento, e utilizar a ferramenta métrica <a href="https://github.com/AlDanial/cloc">CLOC</a> para determinar a quantidade de linhas do código</p>

<h2>Como estava o código antes das mudanças?</h2>

<p>O cloc foi aplicado às classes principais "CalculoDeNutrientesAadicionar.java" e "CorrecaoCTC.java"</p>
<p>Para "CalculoDeNutrientesAadicionar.java":</p>
<img src="https://user-images.githubusercontent.com/32207196/115470629-0198d580-a20d-11eb-9f59-13cc6492b15f.PNG"/>

<p>Para "CorrecaoCTC.java":</p>
<img src="https://user-images.githubusercontent.com/32207196/115470747-2ab96600-a20d-11eb-8ebd-8c7e8808213a.PNG"/>

<h2>Problemas Identificados</h2>
<ul>
  <li>Padrões da linguagem em expressões switch</li>
  <li>Condicionais if e else, onde a complexidade poderia ser diminuida</li>
</ul>

<h2>Soluções</h2>
<ul>
  <li>Encontrado o padrão da linguagem para expressão <a href="https://docs.oracle.com/en/java/javase/15/language/switch-expressions.html">switch</a> e utilização para atribuição de valores repetidos para um mesmo retorno</li>
  <li>Uma proposta encontrada em um <a href="https://docs.oracle.com/en/java/javase/15/language/switch-expressions.html">vídeo</a>, trazia a ideia de subtratir os "elses" com retornos seguidos, ajudando na manutenabilidade e na quantidade de código</li>
</ul>

<h2>Implementação das soluções</h2>
<ul>
  <li>
    <a href="https://github.com/xandea/Arquitetura/commit/27b935d1702e3a1c8400b52e6ac2f76d88ef1751">Estrutura do switch na CorrecaoCTC.java</a>
  </li>
  <li>
    <a href="https://github.com/xandea/Arquitetura/commit/6bdfc7744e09c73a297f2ac01f5d56a7b5f57793">Estrutura do switch na classe CalculoDeNutrientesAadicionar.java</a>
  </li>
  <li>
    <a href="https://github.com/xandea/Arquitetura/commit/2efc4bec2779407f8b2ff7750ce9946fe1db1b23">Estruturas else tratada logo no inicio na função "calculaQTDKgHectareDeFonteDePotassio"</a>
  </li>
</ul>

<h2>Impactos das melhorias</h2>

<p>Para "CalculoDeNutrientesAadicionar.java":</p>
<img src="https://user-images.githubusercontent.com/32207196/115473301-df558680-a211-11eb-91a7-c42b60289066.PNG"/>

<p>Para "CorrecaoCTC.java":</p>
<img src="https://user-images.githubusercontent.com/32207196/115473247-c4831200-a211-11eb-954c-34cc95197009.PNG"/>

<p>Feito todas as mudanças, podemos notar uma diminuição de quase 50% na linha de código. Mostrando-se efetiva as modificações feitas</p>




