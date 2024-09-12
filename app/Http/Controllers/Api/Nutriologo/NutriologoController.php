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
                    'status' => 404,
                    'path' => "/api/v1/insertardatos/{$id}",
                    'timestamp' => now()->toDateTimeString(),
                    'consulta' => null
                ], 404);
            }

            $validatedData = $request->validate([
                'nutriologo_id' => 'required|integer',
                'peso' => 'required|numeric',
                'estatura' => 'required|numeric',
                'imc' => 'required|numeric',
                'porcentaje_grasa' => 'required|numeric',
                'porcentaje_musculo' => 'required|numeric',
                'circunferencia_cintura' => 'required|numeric',
                'circunferencia_cadera' => 'required|numeric',
                'circunferencia_brazo' => 'required|numeric',
                'pliegue_bicipital' => 'required|numeric',
                'pliegue_tricipital' => 'required|numeric',
                'fecha_medicion' => 'required|date',
                'siguiente_consulta' => 'required|date',
            ]);

            $nuevaConsulta = new Tdatos_consulta([
                'nutriologo_id' => $validatedData['nutriologo_id'],
                'paciente_id' => $paciente->id,
                'peso' => $validatedData['peso'],
                'estatura' => $validatedData['estatura'],
                'imc' => $validatedData['imc'],
                'porcentaje_grasa' => $validatedData['porcentaje_grasa'],
                'porcentaje_musculo' => $validatedData['porcentaje_musculo'],
                'circunferencia_cintura' => $validatedData['circunferencia_cintura'],
                'circunferencia_cadera' => $validatedData['circunferencia_cadera'],
                'circunferencia_brazo' => $validatedData['circunferencia_brazo'],
                'pliegue_bicipital' => $validatedData['pliegue_bicipital'],
                'pliegue_tricipital' => $validatedData['pliegue_tricipital'],
                'fecha_medicion' => $validatedData['fecha_medicion'],
                'siguiente_consulta' => $validatedData['siguiente_consulta'],
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

            $agenda = Tdatos_consulta::whereIn('paciente_id', $pacientesIds)->with('paciente.user')->get();

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