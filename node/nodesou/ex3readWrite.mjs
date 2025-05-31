import {promises} from "fs";

const ss = "텍스트 문서를 작성합니다. 작성자는 유비입니다.";

console.log("처리1");

promises
  .writeFile("ex3write.txt", ss)
  .then(() => {
    return promises.readFile("./ex3write.txt", "utf-8");
  })
  .then((data) => {
    console.log(data.toString());
  })
  .catch((err) => {
    console.log(err);
  });

console.log("처리2");