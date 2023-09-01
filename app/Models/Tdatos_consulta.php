<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tdatos_consulta extends Model
{
    use HasFactory;

    protected $fillable = [
        'usuario_paciente_id',
        'fecha_medicion',
        'peso',
        'estatura',
        'imc',
        'porcentaje_grasa',
        'porcentaje_musculo',
        'circunferencia_cintura',
        'circunferencia_cadera',
        'pliegue_bicipital',
        'pliegue_tricipital',
    ];

    public function consulta()
    {
        return $this->belongsTo(User::class, 'usuario_paciente_id', 'id');
    }
}
