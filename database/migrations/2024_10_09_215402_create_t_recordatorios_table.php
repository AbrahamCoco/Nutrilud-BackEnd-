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
        Schema::create('t_recordatorios', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('nutriologo_id');
            $table->unsignedBigInteger('paciente_id');
            $table->string('recordatorioPdf');
            $table->datetime('fecha_recordatorio');
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
        Schema::dropIfExists('t_recordatorios');
    }
};