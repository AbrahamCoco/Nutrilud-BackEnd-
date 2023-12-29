<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\Tarticulos;
use Illuminate\Support\Facades\Validator;
use Illuminate\Http\Request;

class ArticulosController extends Controller
{
    public function index()
    {
        $articulos = Tarticulos::with(['nutriologo.user'])->get();

        return response()->json([
            'message' => 'Lista de articulos',
            'articulos' => $articulos
        ], 200);
    }

    public function show($id)
    {
        $articulo = Tarticulos::with(['nutriologo.user'])->find($id);

        if (is_null($articulo)) {
            return response()->json([
                'message' => 'Articulo no encontrado'
            ], 400);
        }

        return response()->json([
            'message' => 'Articulo encontrado',
            'articulo' => $articulo
        ], 200);
    }

    public function store(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'titulo' => 'required|string',
            'contenido' => 'required|string',
            'nutriologo_id' => 'required|integer',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'message' => 'Error de validacion',
                'errors' => $validator->errors()
            ], 400);
        }

        $articulo = Tarticulos::create($request->all());

        return response()->json([
            'message' => 'Articulo creado correctamente',
            'articulo' => $articulo
        ], 200);
    }
}
