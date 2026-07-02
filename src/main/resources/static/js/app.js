async function insertNode() {

    const value = document.getElementById("value").value;

    if (value === "") return;

    await fetch("/api/insert", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({

            value: Number(value)

        })

    });

    document.getElementById("value").value = "";

    loadTree();

}
async function loadTree(){

    const response = await fetch("/api/tree");

    const root = await response.json();

    const svg = document.getElementById("tree");

    svg.innerHTML="";

    if(root){

        drawTree(root,600,60,250);

    }

}
function drawTree(node,x,y,offset){

    if(node==null)
        return;

    const svg=document.getElementById("tree");

    if(node.left){

        drawLine(
            x,
            y,
            x-offset,
            y+100
        );

        drawTree(
            node.left,
            x-offset,
            y+100,
            offset/1.8
        );

    }

    if(node.right){

        drawLine(
            x,
            y,
            x+offset,
            y+100
        );

        drawTree(
            node.right,
            x+offset,
            y+100,
            offset/1.8
        );

    }

    drawNode(node,x,y);

}
function drawLine(x1,y1,x2,y2){

    const svg=document.getElementById("tree");

    const line=document.createElementNS(
        "http://www.w3.org/2000/svg",
        "line"
    );

    line.setAttribute("x1",x1);

    line.setAttribute("y1",y1);

    line.setAttribute("x2",x2);

    line.setAttribute("y2",y2);

    line.setAttribute("stroke","#8B7355");

    line.setAttribute("stroke-width","3");

    svg.appendChild(line);

}
function drawNode(node,x,y){

    const svg=document.getElementById("tree");

    const circle=document.createElementNS(
        "http://www.w3.org/2000/svg",
        "circle"
    );

    circle.setAttribute("cx",x);

    circle.setAttribute("cy",y);

    circle.setAttribute("r",28);

    circle.setAttribute("fill","#F8F4EE");

    circle.setAttribute("stroke","#6B705C");

    circle.setAttribute("stroke-width","3");

    svg.appendChild(circle);



    const text=document.createElementNS(
        "http://www.w3.org/2000/svg",
        "text"
    );

    text.setAttribute("x",x);

    text.setAttribute("y",y+5);

    text.setAttribute("text-anchor","middle");

    text.setAttribute("font-size","18");

    text.setAttribute("font-weight","bold");

    text.setAttribute("fill","#3D352E");

    text.textContent=node.value;

    svg.appendChild(text);

}
async function deleteNode() {

    const value = document.getElementById("value").value;

    if (value === "") return;

    await fetch("/api/delete", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify({

            value: Number(value)

        })

    });

    document.getElementById("value").value = "";

    loadTree();

}
loadTree();