<?php

namespace App\Http\Controllers\Api\Nutriologo;

use App\Http\Controllers\Controller;
use App\Models\Tdatos_consulta;
use App\Models\Tusuario_paciente;
use Illuminate\Http\Request;

class NutriologoController extends Controller
{
    public function show()
    {
        try {
            $pacientes = Tusuario_paciente::with('user')->get();

            if ($pacientes->isEmpty()) {
                return response()->json([
                    'message' => 'No se encontraron pacientes',
                    'status' => 400,
                    'path' => '/api/v1/pacientes',
                    'timestamp' => now()->toDateTimeString(),
                    'pacientes' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Pacientes encontrados',
                'pacientes' => $pacientes,
                'status' => 200,
                'path' => '/api/v1/pacientes',
                'timestamp' => now()->toDateTimeString()
            ], 200);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Error al obtener los pacientes',
                'status' => 500,
                'path' => '/api/v1/pacientes',
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function showPaciente($id)
    {
        try {
            $paciente = Tusuario_paciente::with('user')->find($id);

            if ($paciente === null) {
                return response()->json([
                    'message' => 'Paciente no encontrado',
                    'status' => 400,
                    'path' => "/api/v1/paciente/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'paciente' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Paciente encontrado',
                'paciente' => $paciente,
                'status' => 200,
                'path' => "/api/v1/paciente/{$id}",
                'timestamp' => now()->toDateTimeString()
            ], 200);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Error al obtener el paciente',
                'status' => 500,
                'path' => "/api/v1/paciente/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function showAllDatos($id)
    {
        try {
            $paciente = Tusuario_paciente::with('user')->find($id);
            if ($paciente === null) {
                return response()->json([
                    'message' => 'Paciente no encontrado',
                    "status" => 400,
                    'path' => "/api/v1/consultadatos/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'consulta' => null
                ], 400);
            }

            $consulta = Tdatos_consulta::where('paciente_id', $paciente->id)->get();

            if ($consulta->isEmpty()) {
                return response()->json([
                    'message' => 'No se encontraron datos de consulta',
                    "status" => 400,
                    'path' => "/api/v1/consultadatos/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'consulta' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Datos de consulta encontrados',
                'status' => 200,
                'path' => "/api/v1/consultadatos/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'consulta' => $consulta
            ], 200);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Error al obtener los datos de consulta',
                'status' => 500,
                'path' => "/api/v1/consultadatos/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'consulta' => null,
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function insertarDatos(Request $request, $id)
    {
        try {
            $paciente = Tusuario_paciente::find($id);

            if ($paciente === null) {
                return response()->json([
                    'message' => 'Paciente no encontrado',
                    'status' => 400,
                    'path' => "/api/v1/insertardatos/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'consulta' => null
                ], 400);
            }

            $nuevaConsulta = new Tdatos_consulta([
                'paciente_id' => $paciente->id,
                'peso' => $request->input('peso'),
                'estatura' => $request->input('estatura'),
                'imc' => $request->input('imc'),
                'porcentaje_grasa' => $request->input('porcentaje_grasa'),
                'porcentaje_musculo' => $request->input('porcentaje_musculo'),
                'circunferencia_cintura' => $request->input('circunferencia_cintura'),
                'circunferencia_cadera' => $request->input('circunferencia_cadera'),
                'circunferencia_brazo' => $request->input('circunferencia_brazo'),
                'pliegue_bicipital' => $request->input('pliegue_bicipital'),
                'pliegue_tricipital' => $request->input('pliegue_tricipital'),
                'fecha_medicion' => $request->input('fecha_medicion'),
                'siguiente_consulta' => $request->input('siguiente_consulta'),
            ]);

            $paciente->consulta()->save($nuevaConsulta);

            return response()->json([
                'message' => 'Datos de consulta guardados',
                'nuevaConsulta' => $nuevaConsulta,
                'status' => 201,
                'path' => "/api/v1/insertardatos/{$id}",
                'timestamp' => now()->toDateTimeString()
            ], 201);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Error al guardar los datos de consulta',
                'status' => 500,
                'path' => "/api/v1/insertardatos/{$id}",
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }

    public function agenda()
    {
        try {
            $pacientes = Tusuario_paciente::with('user')->get();

            if ($pacientes->isEmpty()) {
                return response()->json([
                    'message' => 'No se encontraron pacientes',
                    'status' => 400,
                    'path' => '/api/v1/nutriologo/agenda',
                    'timestamp' => now()->toDateTimeString(),
                    'agenda' => null
                ], 400);
            }

            $pacientesIds = $pacientes->pluck('id');

            $agenda = Tdatos_consulta::whereIn('paciente_id', $pacientesIds)->with('consulta.user')->get();

            if ($agenda->isEmpty()) {
                return response()->json([
                    'message' => 'No se encontraron datos para agenda',
                    'status' => 400,
                    'path' => '/api/v1/nutriologo/agenda',
                    'timestamp' => now()->toDateTimeString(),
                    'agenda' => null
                ], 400);
            }

            return response()->json([
                'message' => 'Datos para agendar encontrados',
                'agenda' => $agenda,
                'status' => 200,
                'path' => '/api/v1/nutriologo/agenda',
                'timestamp' => now()->toDateTimeString()
            ], 200);
        } catch (\Exception $e) {
            return response()->json([
                'message' => 'Error al obtener la agenda',
                'status' => 500,
                'path' => '/api/v1/nutriologo/agenda',
                'timestamp' => now()->toDateTimeString(),
                'error' => $e->getMessage()
            ], 500);
        }
    }
}
