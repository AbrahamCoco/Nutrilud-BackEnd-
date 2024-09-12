<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tdatos_consulta extends Model
{
    use HasFactory;

    protected $fillable = [
        'nutriologo_id',
        'paciente_id',
        'fecha_medicion',
        'peso',
        'estatura',
        'imc',
        'porcentaje_grasa',
        'porcentaje_musculo',
        'circunferencia_cintura',
        'circunferencia_cadera',
        'circunferencia_brazo',
        'pliegue_bicipital',
        'pliegue_tricipital',
        'siguiente_consulta',
    ];

    public function nutriologo()
    {
        return $this->belongsTo(Tusuario_nutriologo::class, 'nutriologo_id', 'id');
    }

    public function paciente()
    {
        return $this->belongsTo(Tusuario_paciente::class, 'paciente_id', 'id');
    }
}