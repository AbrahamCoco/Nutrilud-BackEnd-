<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class TRecordatorios extends Model
{
    use HasFactory;

    protected $fillable = [
        'nutriologo_id',
        'paciente_id',
        'recordatorioPdf',
        'fecha_recordatorio'
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
