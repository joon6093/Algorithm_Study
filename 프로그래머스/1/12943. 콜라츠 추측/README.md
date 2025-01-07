# [level 1] 콜라츠 추측 - 12943 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12943) 

### 성능 요약

메모리: 89.1 MB, 시간: 0.04 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 01월 07일 21:45:14

### 문제 설명

<p style="user-select: auto !important;">1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다. </p>
<div class="highlight" style="user-select: auto !important;"><pre class="codehilite" style="user-select: auto !important;"><code style="user-select: auto !important;">1-1. 입력된 수가 짝수라면 2로 나눕니다. 
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. 
</code></pre></div>
<p style="user-select: auto !important;">예를 들어, 주어진 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다. 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요. 단, 주어진 수가 1인 경우에는 0을, 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환해 주세요. </p>

<h5 style="user-select: auto !important;">제한 사항</h5>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">입력된 수, <code style="user-select: auto !important;">num</code>은 1 이상 8,000,000 미만인 정수입니다. </li>
</ul>

<h5 style="user-select: auto !important;">입출력 예</h5>
<table class="table" style="user-select: auto !important;">
        <thead style="user-select: auto !important;"><tr style="user-select: auto !important;">
<th style="user-select: auto !important;">n</th>
<th style="user-select: auto !important;">result</th>
</tr>
</thead>
        <tbody style="user-select: auto !important;"><tr style="user-select: auto !important;">
<td style="user-select: auto !important;">6</td>
<td style="user-select: auto !important;">8</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">16</td>
<td style="user-select: auto !important;">4</td>
</tr>
<tr style="user-select: auto !important;">
<td style="user-select: auto !important;">626331</td>
<td style="user-select: auto !important;">-1</td>
</tr>
</tbody>
      </table>
<h5 style="user-select: auto !important;">입출력 예 설명</h5>

<p style="user-select: auto !important;">입출력 예 #1 <br style="user-select: auto !important;">
문제의 설명과 같습니다. </p>

<p style="user-select: auto !important;">입출력 예 #2 <br style="user-select: auto !important;">
16 → 8 → 4 → 2 → 1 이 되어 총 4번 만에 1이 됩니다. </p>

<p style="user-select: auto !important;">입출력 예 #3 <br style="user-select: auto !important;">
626331은 500번을 시도해도 1이 되지 못하므로 -1을 리턴해야 합니다.</p>

<hr style="user-select: auto !important;">

<p style="user-select: auto !important;">※ 공지 - 2022년 6월 10일 다음과 같이 지문이 일부 수정되었습니다.</p>

<ul style="user-select: auto !important;">
<li style="user-select: auto !important;">주어진 수가 1인 경우에 대한 조건 추가</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges