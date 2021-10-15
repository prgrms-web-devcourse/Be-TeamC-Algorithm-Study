import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        // Cars 
        List<Car> cars = new ArrayList<>();

        // Cars 데이터 삽입
        for (int i = 0; i < routes.length; i++) {
            cars.add(new Car(routes[i][0], routes[i][1]));
        }
        
        // start와 end Point를 기준으로 정렬
        Collections.sort(cars);

        // 처음 들어오는 기준 차량 1대 초기화
        int result = 1;
        
        // 처음 들어오는 차량의 endPoint가 기준점
        int point = cars.get(0).end;
        
        for (Car car : cars) {
            // 현재 차량이 도로를 나간 지점보다 늦게 다음 차량이 들어오는 경우
            if (point < car.start) {
                result++; // 새로운 카메라 설치
                point = car.end; 
            }

            // 현재 차량이 도로를 나간 지점보다 앞서 다음 차량이 나가는 경우
            if (point >= car.end) {
                point = car.end; // 기준점을 변경시킴
            }
        }
        
        return result;
    }
}

// 자동차의 start, end Point를 정렬시켜줌!
class Car implements Comparable<Car> {
    int start;
    int end;

    public Car(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Car o) {
        if (this.start > o.start) {
            return 1;
        } else if (this.start < o.start) {
            return -1;
        } else {
            return this.end - o.end;
        }
    }
}
