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
        try {
            $articulos = Tarticulos::with(['nutriologo.user'])->get();

            if ($articulos->isEmpty()) {
                return response()->json([
                    'message' => 'No se encontraron articulos',
                    'status' => 400,
                    'path' => '/api/v1/articulos',
                    'timestamp' => now()->toDateTimeString(),
                    'articulos' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Lista de articulos',
                'articulos' => $articulos,
                'status' => 200,
                'path' => '/api/v1/articulos',
                'timestamp' => now()->toDateTimeString()
            ], 200);
        } catch (\Throwable $e) {
            return response()->json([
                'message' => 'Error al obtener los articulos',
                'status' => 500,
                'path' => '/api/v1/articulos',
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function show($id)
    {
        try {
            $articulo = Tarticulos::with(['nutriologo.user'])->find($id);

            if (is_null($articulo)) {
                return response()->json([
                    'message' => 'Articulo no encontrado',
                    'status' => 400,
                    'path' => "/api/v1/articulo/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'articulo' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Articulo encontrado',
                'status' => 200,
                'path' => "/api/v1/articulo/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'articulo' => $articulo
            ], 200);
        } catch (\Throwable $e) {
            return response()->json([
                'message' => 'Error al obtener el articulo',
                'status' => 500,
                'path' => "/api/v1/articulo/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function store(Request $request)
    {
        try {
            $validator = Validator::make($request->all(), [
                'contenido' => 'required|string',
                'foto' => 'required|string',
                'nutriologo_id' => 'required|integer',
            ]);

            if ($validator->fails()) {
                return response()->json([
                    'message' => 'Error de validacion',
                    'status' => 400,
                    'path' => '/api/v1/nutriologo/articulos',
                    'timestamp' => now()->toDateTimeString(),
                    'errors' => $validator->errors()
                ], 400);
            }

            $articulo = Tarticulos::create($request->all());

            return response()->json([
                'message' => 'Articulo creado correctamente',
                'status' => 201,
                'path' => '/api/v1/nutriologo/articulos',
                'timestamp' => now()->toDateTimeString(),
                'articulo' => $articulo
            ], 201);
        } catch (\Throwable $e) {
            return response()->json([
                'message' => 'Error al crear el articulo',
                'status' => 500,
                'path' => '/api/v1/nutriologo/articulos',
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }
}
