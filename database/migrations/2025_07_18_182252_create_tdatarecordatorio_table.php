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
        Schema::create('tdatarecordatorio', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('t_recordatorio_id');
            $table->string("comida");
            $table->string("hora");
            $table->string("lugar");
            $table->string("alimentos");
            $table->string("porciones");
            $table->string("marca");
            $table->string("preparacion");
            $table->string("otros");
            $table->string("observaciones");
            $table->foreign('t_recordatorio_id')->references('id')->on('t_recordatorios');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tdatarecordatorio');
    }
};
