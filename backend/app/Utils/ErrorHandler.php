<?php

namespace App\Utils;

use Illuminate\Http\JsonResponse;

class ErrorHandler
{
    /**
     * Maneja errores de servicio no disponible.
     *
     * @param \Exception $error
     * @return JsonResponse
     */
    public function handleServiceUnavailable(): JsonResponse
    {
        return response()->json(
            [
                'status' => 'error',
                'code' => 503,
                'message' => 'Service unavailable',
                'data' => null,
            ],
            503
        );
    }
}
