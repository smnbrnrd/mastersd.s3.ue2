// function to create and draw node-like primitives with the options to customize edge color fill color, text color, and text size
function d3Node(parentTag, node, options) {
    // Default options
    const defaultOptions = {
        edgeColor: 'black',
        fillColor: 'lightgray',
        textColor: 'black',
        textSize: '12px'
    };

    // Merge user options with default options
    const finalOptions = { ...defaultOptions, ...options };

    // Create the node primitive
    const nodePrimitive = {
        id: node.id,
        label: node.label,
        edgeColor: finalOptions.edgeColor,
        fillColor: finalOptions.fillColor,
        textColor: finalOptions.textColor,
        textSize: finalOptions.textSize
    };

    // Draw the node primitive using D3.js
    parentTag.append('div')
        .attr('id', nodePrimitive.id)
        .style('border', `1px solid ${nodePrimitive.edgeColor}`)
        .style('background-color', nodePrimitive.fillColor)
        .style('color', nodePrimitive.textColor)
        .style('font-size', nodePrimitive.textSize)
        .text(nodePrimitive.label);
}