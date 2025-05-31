// 비동기로 파일, 웹문서 읽기 + 이벤트 처리 (모듈 분리 배치 버전)

//  파일 관련 모듈
import fs, { readFile } from 'fs';                         // 파일 시스템 모듈
import { EventEmitter } from 'events';                     // 이벤트 모듈 (공통)

const fileEvent = new EventEmitter();                      // 파일 읽기용 인스턴스

//  파일 읽기 이벤트 등록
fileEvent.on('myreadfile', (filePath) => {
    console.log('\n [파일 읽기 시작]');
    readFile(filePath, 'utf-8', (err, data) => {
        if (err) {
            console.error(' error reading file:', err);
            return;
        }
        console.log(data);
        console.log(' [파일 읽기 끝]');
    });
});

fileEvent.emit('myreadfile', 'ex3read.txt');
console.log(' 파일 내용이 궁금해?');

console.log('\n 비동기 처리로 웹 문서 읽기-----------------');

//  웹문서 요청 처리 부분 (여기서 모듈 따로 import)
import https from 'https';                                 // 웹요청용 모듈 여기서 import
const webEvent = new EventEmitter();                       // 웹 요청용 인스턴스 여기서 생성

//  웹문서 이벤트 등록
webEvent.on('myfetchData', () => {
    console.log('\n [웹문서 요청 시작]');
    https.get('https://jsonplaceholder.typicode.com/posts/1', (resp) => {
        let data = '';

        resp.on('data', (chunk) => {
            data += chunk;
        });

        resp.on('end', () => {
            console.log('\n [웹문서 응답 완료]');
            try {
                console.log('data :', data);
                const jsonData = JSON.parse(data);
                console.log('jsonData :', jsonData);
                console.log(' [웹문서 출력 끝]');
            } catch (error) {
                console.log(' parsing err :', error);
            }
        });
    }).on('error', (err) => {
        console.log(' fetch fail :', err.message);
    });
});

webEvent.emit('myfetchData');
console.log(' 웹 문서 내용이 궁금해?');
