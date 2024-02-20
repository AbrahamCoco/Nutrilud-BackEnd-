import React from "react";

const ImagePreview = ({ selectedImage }) => {
    return (
        <div className="col-sm-6">
            {selectedImage && <img src={selectedImage} className="img-fluid imagen" alt="Previsualizacion" />}
        </div>
    );
}
 
export default ImagePreview;