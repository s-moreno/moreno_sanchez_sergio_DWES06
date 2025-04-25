<?php

namespace App\Http\Controllers;

use App\Utils\ErrorHandler;
use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;
use Illuminate\Support\Facades\Http;

class CategoryGatewayController extends Controller
{
    private string $baseUrl;
    private ErrorHandler $errorHandler;

    /**
     * Constructor.
     * Inicializa la URL base de la API para la gestión de categorías.
     */
    public function __construct(ErrorHandler $errorHandler)
    {
        $this->baseUrl = config('services.stock_api_url') . '/api/categories';
        $this->errorHandler = $errorHandler;
    }

    /**
     * Mostrar una lista de todas las categorías.
     * Realiza una solicitud GET a la API externa para obtener la lista de categorías.
     *
     * @return JsonResponse
     */
    public function index(): JsonResponse
    {
        try {
            $response = Http::get($this->baseUrl);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Crear una nueva categoría y almacenarla en la base de datos.
     * Realiza una solicitud POST a la API externa para crear una nueva categoría.
     *
     * @param Request $request
     * @return JsonResponse
     */
    public function store(Request $request): JsonResponse
    {
        try {
            $response = Http::post($this->baseUrl, $request->all());
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Mostrar la categoría especificada.
     * Realiza una solicitud GET a la API externa para obtener los detalles de una categoría específica.
     *
     * @param string $id
     * @return JsonResponse
     */
    public function show(string $id): JsonResponse
    {
        try {
            $response = Http::get($this->baseUrl . '/' . $id);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Actualizar la categoría especificada.
     * Realiza una solicitud PUT a la API externa para actualizar los detalles de una categoría específica.
     *
     * @param Request $request
     * @param string $id
     * @return JsonResponse
     */
    public function update(Request $request, string $id): JsonResponse
    {
        try {
            $response = Http::put($this->baseUrl . '/' . $id, $request->all());
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }

    /**
     * Eliminar la categoría especificada.
     *
     * @param string $id
     * @return JsonResponse
     */
    public function destroy(string $id): JsonResponse
    {
        try {
            $response = Http::delete($this->baseUrl . '/' . $id);
            return response()->json($response->json(), $response->status());
        } catch (\Exception $e) {
            return $this->errorHandler->handleServiceUnavailable();
        }
    }
}
