import api.DatabaseAPI;
import model.DataEntity;

public class Main {
    public static void main(String[] args) {
        DatabaseAPI api = new DatabaseAPI();

        // Пример использования API
        System.out.println("=== Пример работы с API ===");

        // Получение read-only данных (должно кэшироваться)
        DataEntity data1 = api.getData("1");
        System.out.println("Data 1: " + data1.getContent());

        // Повторное получение - должно быть из кэша
        DataEntity data1Cached = api.getData("1");
        System.out.println("Data 1 (cached): " + data1Cached.getContent());

        // Получение writable данных (не кэшируется)
        DataEntity data3 = api.getData("3");
        System.out.println("Data 3: " + data3.getContent());

        // Обновление данных
        api.updateData("3", "Updated writable data");
        DataEntity updatedData3 = api.getData("3");
        System.out.println("Updated Data 3: " + updatedData3.getContent());

        // Генерация отчета
        System.out.println("\n=== Полный отчет ===");
        api.generateReport().forEach((id, entity) ->
                System.out.println(id + ": " + entity.getContent() +
                        " (" + entity.getType() + ")")
        );

        // Для демонстрации работы таймера оставим приложение работать некоторое время
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}