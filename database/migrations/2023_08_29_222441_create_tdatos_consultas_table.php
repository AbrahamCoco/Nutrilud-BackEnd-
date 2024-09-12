<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('tdatos_consultas', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('nutriologo_id');
            $table->unsignedBigInteger('paciente_id');
            $table->float('peso');
            $table->float('estatura');
            $table->float('porcentaje_grasa');
            $table->float('porcentaje_musculo');
            $table->float('imc');
            $table->float('circunferencia_cintura');
            $table->float('circunferencia_cadera');
            $table->float('circunferencia_brazo');
            $table->float('pliegue_bicipital');
            $table->float('pliegue_tricipital');
            $table->datetime('fecha_medicion');
            $table->datetime('siguiente_consulta');
            $table->foreign('nutriologo_id')->references('id')->on('tusuario_nutriologos');
            $table->foreign('paciente_id')->references('id')->on('tusuario_pacientes');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tdatos_consultas');
    }
};