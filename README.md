# TP1Duna
Trabalho prático Algoritmos e Programação (Difícil) Temática: Duna

Você é o governador de Arrakis e deve gerenciar a extração de especiaria (melange) em um ambiente hostil. O programa simulará um ano (12 ciclos) de operações. Em cada ciclo, você decide quantas colheitadeiras enviar para o deserto, sabendo que mais máquinas aumentam a produção mas também atraem mais vermes da areia.

A probabilidade de ataque de vermes é calculada como: 10% × (número de colheitadeiras) × (1 + fator climático). O fator climático varia aleatoriamente entre 0 e 1 a cada ciclo. Cada colheitadeira produz entre 100 e 300 unidades de especiaria por ciclo, mas se um verme atacar, você perde 1d6 colheitadeiras (isto é, um número aleatório entre 1 e 6) e toda a produção do ciclo.

Você começa com 10 colheitadeiras e pode:
Comprar mais colheitadeiras (custo: 500 unidades de especiaria cada)
Contratar Fremen para espantar vermes (cada grupo de Fremen custa 200 unidades por ciclo e reduz a probabilidade de ataque em 5%, sendo possível contratar múltiplos grupos para redução cumulativa)
O Imperador exige um tributo de 1000 unidades de especiaria a cada 3 ciclos. Não pagá-lo resulta nas seguintes penalidades:
- Primeiro atraso: multa de 500 unidades de especiaria
- Segundo atraso: confisco de 2 colheitadeiras
- Terceiro atraso: destituição do cargo (fim de jogo)

O programa deve simular os 12 ciclos, permitindo decisões a cada ciclo e mostrando o resultado final: quantidade de 
  especiaria acumulada, colheitadeiras restantes, ataques de vermes sofridos e se você conseguiu cumprir as exigências do Imperador
