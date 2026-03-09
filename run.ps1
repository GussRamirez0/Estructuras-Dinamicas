# Script PowerShell para compilar y ejecutar la Lista Doblemente Enlazada
# USO: .\run.ps1

# Intentar encontrar JAVAC en el PATH del sistema
$JAVAC_PATH = $null
$JAVA_PATH = $null

try {
    $JAVAC_PATH = (Get-Command javac -ErrorAction Stop).Source
    $JAVA_PATH = (Get-Command java -ErrorAction Stop).Source
} catch {
    # Si no esta en PATH, buscar en rutas comunes
    
    # Buscar en Program Files
    $jdk_paths = @(
        "C:\Program Files\Java",
        "C:\Program Files (x86)\Java"
    )
    
    foreach ($base_path in $jdk_paths) {
        if (Test-Path $base_path) {
            $jdk_dirs = Get-ChildItem $base_path -Directory | Where-Object {$_.Name -match "jdk.*"}
            foreach ($jdk_dir in $jdk_dirs) {
                $javac_candidate = Join-Path $jdk_dir.FullName "bin\javac.exe"
                $java_candidate = Join-Path $jdk_dir.FullName "bin\java.exe"
                
                if ((Test-Path $javac_candidate) -and (Test-Path $java_candidate)) {
                    $JAVAC_PATH = $javac_candidate
                    $JAVA_PATH = $java_candidate
                    break
                }
            }
            if ($JAVAC_PATH) { break }
        }
    }
}

# Verificar si se encontro Java
if (-not $JAVAC_PATH) {
    Write-Host "" -ForegroundColor Red
    Write-Host "========================================" -ForegroundColor Red
    Write-Host "ERROR: No se encontró Java (JDK)" -ForegroundColor Red
    Write-Host "========================================" -ForegroundColor Red
    Write-Host ""
    Write-Host "Por favor:" -ForegroundColor Yellow
    Write-Host "1. Instala JDK desde: https://www.oracle.com/java/technologies/downloads/" -ForegroundColor Yellow
    Write-Host "2. O configura Java en el PATH del sistema" -ForegroundColor Yellow
    Write-Host ""
    exit 1
}

# Compilar
Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Compilando archivos Java..." -ForegroundColor Cyan
Write-Host "Usando: $JAVAC_PATH" -ForegroundColor Gray
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

& $JAVAC_PATH DoublyNode.java DoublyLinkedList.java Main.java 2>&1

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "✗ Error en la compilación" -ForegroundColor Red
    exit 1
}

Write-Host ""
Write-Host "✓ Compilación exitosa!" -ForegroundColor Green
Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Ejecutando programa..." -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Ejecutar
& $JAVA_PATH Main

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "Programa finalizado" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
